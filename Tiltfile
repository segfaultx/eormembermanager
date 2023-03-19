version_settings(constraint='>=0.22.2')

docker_build(
    'myapp',
    context='.',
    dockerfile='./Dockerfile'
)

k8s_yaml('app_deployment.yaml')

k8s_resource(
    'member-manager-deployment',
    port_forwards='8080:8080',
    labels=['backend']
)

k8s_yaml('db_deployment.yaml')

k8s_resource(
    'member-manager-db-deployment',
    port_forwards='27017:27017',
    labels=['mongodb']
)