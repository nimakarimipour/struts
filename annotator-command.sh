lib=true
arg=true
poly=true
cf_version="3.42.0"
ucrt_version="0.1-alpha-3-SNAPSHOT"
rm -rvf core/target
CF_VERSION=$cf_version UCRT_VERSION=$ucrt_version ANNOTATOR_POLY=$poly ANNOTATOR_LIBRARY=$lib ANNOTATOR_TYPE_ARG=$arg mvn compile -pl core