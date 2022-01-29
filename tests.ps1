javac -d "bin" -cp "lib/junit-4.13.2.jar" ".\src\SnakesAndLadders\*.java" ".\tests\SnakesAndLadders\*.java" 
java -jar "lib/junit-platform-console-standalone-1.8.2.jar" -cp "bin" --scan-classpath
Remove-Item "bin" -Recurse -Force -Confirm:$false