#!/bin/bash
set -euxo pipefail

# Build Chicory
(
  cd chicory
  mvn clean package
)

# Build Truffle
(
  cd truffle
  mvn clean package
)

# Run Chicory
./chicory/target/main

# Run Truffle
./truffle/target/main
