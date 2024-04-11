lib=true
arg=true
poly=true
cf_version="3.42.0"
c_version="0.1"
rm -rvf core/target > /dev/null
CF_VERSION=$cf_version C_VERSION=$c_version ANNOTATOR_POLY=$poly ANNOTATOR_LIBRARY=$lib ANNOTATOR_TYPE_ARG=$arg mvn compile -pl core