# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
#     this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
#     the License.  You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import subprocess
import os
import shutil
from pathlib import Path

VERSION = '1.3.9-SNAPSHOT'
MODULE = 'core'
REPO = subprocess.check_output(['git', 'rev-parse', '--show-toplevel']).strip().decode('utf-8')
OUT_DIR = '{}/annotator-out/core'.format(REPO)
ANNOTATOR_JAR = "{}/.m2/repository/edu/ucr/cs/riple/annotator/annotator-core/{}/annotator-core-{}.jar".format(str(Path.home()), VERSION, VERSION)

def prepare():
    os.makedirs(OUT_DIR, exist_ok=True)
    shutil.rmtree('{}/0'.format(OUT_DIR), ignore_errors=True)
    with open('{}/paths.tsv'.format(OUT_DIR), 'w') as o:
        o.write("{}\t{}\n".format('{}/taint.xml'.format(OUT_DIR), '{}/scanner.xml'.format(OUT_DIR)))


def run_annotator():
    prepare()
    commands = []
    commands += ["java", "-jar", ANNOTATOR_JAR]
    commands += ['-d', OUT_DIR]
    commands += ['-bc', 'cd {} && mvn clean compile -DskipTests -pl {} -am'.format(REPO, MODULE)]
    commands += ['-cp', '{}/paths.tsv'.format(OUT_DIR)]
    commands += ['-i', 'edu.ucr.Initializer']
    commands += ['-n', 'edu.ucr.cs.riple.taint.ucrtainting.qual.RUntainted']
    commands += ['-cn', 'UCRTaint']
    commands += ["--depth", "5"]
    # Uncomment to see build output
    # commands += ['-rboserr']
    # Uncomment to disable outer loop
    # commands += ['-dol']
    # Uncomment to disable parallel processing
    # commands += ['--disable-parallel-processing']

    subprocess.call(commands)


run_annotator()
