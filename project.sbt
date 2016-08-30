sbtPlugin := false

name := "org.omg.oti.uml.json"

moduleName := "org.omg.oti.uml.json"

organization := "TIWG"

homepage := Some(url("https://github.com/TIWG/org.omg.oti.uml.json"))

organizationName := "OMG Tool-Infrastructure Working Group"

organizationHomepage := Some(url("https://github.com/TIWG"))

git.remoteRepo := "git@github.com:TIWG/org.omg.oti.uml.json"

startYear := Some(2016)

scmInfo := Some(ScmInfo(
  browseUrl = url("https://github.com/TIWG/org.omg.oti.uml.json"),
  connection = "scm:"+git.remoteRepo.value))

developers := List(
  Developer(
    id="NicolasRouquette",
    name="Nicolas F. Rouquette",
    email="nicolas.f.rouquette@jpl.nasa.gov",
    url=url("https://github.com/NicolasRouquette")))
