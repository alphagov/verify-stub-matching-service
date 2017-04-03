#!/usr/bin/env bash

set -e
set -u

if [ -z "${GITHUB_API_TOKEN:-}" ]
then
  >&2 echo 'GITHUB_API_TOKEN must be set'
  exit 1
fi

if [ -z "${BUILD_NUMBER:-}" ]
then
  >&2 echo 'BUILD_NUMBER must be set'
  exit 1
fi

VERSION="$(./gradlew --quiet version)"
API_JSON=$(cat <<EOF
{
  "tag_name": "build_$BUILD_NUMBER",
  "target_commitish": "master",
  "name": "v$VERSION",
  "body": "Release of version $VERSION",
  "draft": false,
  "prerelease": false
}
EOF
)

RELEASE_ID=$(\
  curl --fail --data "$API_JSON"\
  "https://api.github.com/repos/alphagov/verify-stub-matching-service/releases?access_token=$GITHUB_API_TOKEN" |
  ruby -e 'require "json"; puts JSON.parse(ARGF.read)["id"]')

cd build/libs

FILENAME="local-matching-service-$VERSION.jar"

curl --fail -X POST \
  --header "Content-Type:application/java-archive"\
  --data-binary @"$FILENAME"\
  "https://uploads.github.com/repos/alphagov/verify-stub-matching-service/releases/$RELEASE_ID/assets?name=$FILENAME&access_token=$GITHUB_API_TOKEN"

