#!/bin/bash

set -ev

# Deploy if TRAVIS_SECURE_ENV_VARS is true and TRAVIS_TAG is set

[ ${TRAVIS_SECURE_ENV_VARS} == false ] && exit 0;
[ -z "${TRAVIS_TAG}" ] && exit 0;

sbt -jvm-opts travis/jvmopts.compile -Dproject.version=$TRAVIS_TAG publishSigned ghpagesPushSite

