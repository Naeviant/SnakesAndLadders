Set-Location .\src
javac .\SnakesAndLadders\* .\Driver.java -d "..\bin"
Set-Location .\..\bin
java Driver
Set-Location .\..\
Remove-Item "bin" -Recurse -Force -Confirm:$false