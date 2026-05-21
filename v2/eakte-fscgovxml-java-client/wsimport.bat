@echo off
wsimport ^
  -keep ^
  -verbose ^
  -Xnocompile ^
  -p de.muenchen.itm.eakte.schnittstelle.fscgovxml.javaclient ^
  -s target/generated-sources/wsimport ^
  src/main/resources/wsdl/fscgovxml-10.wsdl