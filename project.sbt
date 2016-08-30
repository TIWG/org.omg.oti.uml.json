sbtPlugin := false

name := "org.omg.oti.uml.json.schema"

description := "Json serialization for OMG Tool-Interoperability API for OMG-compliant UML 2.5 & later."

moduleName := "org.omg.oti.uml.json.schema"

organization := "TIWG"

homepage := Some(url(s"https://github.com/${organization.value}/${moduleName.value}"))

organizationName := "OMG Tool-Infrastructure Working Group"

organizationHomepage := Some(url(s"https://github.com/${organization.value}"))

git.remoteRepo := s"git@github.com:${organization.value}/${moduleName.value}"

startYear := Some(2016)

scmInfo := Some(ScmInfo(
  browseUrl = url(s"https://github.com/${organization.value}/${moduleName.value}"),
  connection = "scm:"+git.remoteRepo.value))

developers := List(
  Developer(
    id="NicolasRouquette",
    name="Nicolas F. Rouquette",
    email="nicolas.f.rouquette@jpl.nasa.gov",
    url=url("https://github.com/NicolasRouquette")))
