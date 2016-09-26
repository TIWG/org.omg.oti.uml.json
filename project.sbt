sbtPlugin := false

name := "org.omg.oti.uml.json.schema"

description := "Json serialization for OMG Tool-Interoperability API for OMG-compliant UML 2.5 & later."

moduleName := "org.omg.oti.uml.json.schema"

organization := "org.omg.tiwg"

homepage := Some(url(s"https://github.com/TIWG/${moduleName.value}"))

organizationName := "OMG Tool-Infrastructure Working Group"

organizationHomepage := Some(url(s"https://github.com/TIWG"))

git.remoteRepo := s"git@github.com:TIWG/${moduleName.value}"

startYear := Some(2016)

scmInfo := Some(ScmInfo(
  browseUrl = url(s"https://github.com/TIWG/${moduleName.value}"),
  connection = "scm:"+git.remoteRepo.value))

developers := List(
  Developer(
    id="NicolasRouquette",
    name="Nicolas F. Rouquette",
    email="nicolas.f.rouquette@jpl.nasa.gov",
    url=url("https://github.com/NicolasRouquette")))
