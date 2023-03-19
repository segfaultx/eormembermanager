version_settings(constraint='>=0.22.2')

local_resource(
  'myapp-resource',
  'cd MemberManagerBackend &&' +
  './gradlew bootJar',
  deps=['MemberManagerBackend/src', 'build.gradle'],
  labels=['bootJar-resource']
 )

docker_build(
    'myapp',
    context='./MemberManagerBackend',
    dockerfile='./MemberManagerBackend/Dockerfile'
)

k8s_yaml('deployments/app_deployment.yaml')

k8s_resource(
    'member-manager-deployment',
    port_forwards=['8080:8080', '5005:5005'],
    labels=['backend'],
    resource_deps=['myapp-resource']
)

k8s_yaml('deployments/db_deployment.yaml')

k8s_resource(
    'member-manager-db-deployment',
    port_forwards='27017:27017',
    labels=['mongodb']
)