#!/bin/bash

set -ev

[ ${TRAVIS_SECURE_ENV_VARS} == false ] && exit 0;
[ -z ${TRAVIS_TAG} ] && exit 0;

sbt -jvm-opts travis/jvmopts.compile -Dproject.version=$TRAVIS_TAG publishSigned ghpagesPushSite

