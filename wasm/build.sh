#!/bin/bash
set -euxo pipefail

SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
  
rustc $SCRIPT_DIR/add.rs --target=wasm32-unknown-unknown --crate-type=cdylib -o $SCRIPT_DIR/add.wasm
