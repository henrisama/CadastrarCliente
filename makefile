DIR_ENV = 'src/env'
FILE_ENV = 'src/env/Env.java'

JC = javac

# -------- run --------
run: MainCompiler
	java -cp .:lib/mysql-connector-java-8.0.28.jar src/Main && make clean

MainCompiler:
	$(JC) src/Main.java

# -------- migration --------
migration: MigrationExe clean
	
MigrationExe: MigrationCompiler
	java -cp .:lib/mysql-connector-java-8.0.28.jar src/config/Migration

MigrationCompiler:
	$(JC) src/config/Migration.java

clean:
	$(RM) src/config/*.class src/DAO/*.class src/utils/*.class src/views/*.class src/*.class