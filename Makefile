
build:
	mvn clean package

deploy:
	mvn package deploy:deploy -DaltDeploymentRepository=remote-repository::default::https://maven.aksw.org/repository/internal -DaltSnapshotDeploymentRepository=remote-repository::default::https://maven.aksw.org/repository/snapshots
