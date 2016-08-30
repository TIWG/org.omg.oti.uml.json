#!/bin/bash

set -ev

sbt -jvm-opts travis/jvmopts.compile artifacts makeSite

