#!/bin/bash

set -ev
sbt -jvm-opts travis/jvmopts.compile -Dproject.version=$TRAVIS_TAG publishSigned ghpagesPushSite

