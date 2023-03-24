<!--
SPDX-FileCopyrightText: 2023 Alliander N.V.

SPDX-License-Identifier: Apache-2.0
-->

[![Build Project Github Action Status](https://img.shields.io/github/workflow/status/com-pas/compas-sitipe-service/Build%20Project?logo=GitHub)](https://github.com/com-pas/compas-sitipe-service/actions?query=workflow%3A"Build+Project")
[![REUSE status](https://api.reuse.software/badge/github.com/com-pas/compas-sitipe-service)](https://api.reuse.software/info/github.com/com-pas/compas-sitipe-service)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com-pas_compas-sitipe-service&metric=alert_status)](https://sonarcloud.io/dashboard?id=com-pas_compas-sitipe-service)
[![CII Best Practices](https://bestpractices.coreinfrastructure.org/projects/5925/badge)](https://bestpractices.coreinfrastructure.org/projects/5925)
[![Slack](https://raw.githubusercontent.com/com-pas/compas-architecture/master/public/LFEnergy-slack.svg)](http://lfenergy.slack.com/)

# CoMPAS Sitipe-service
The CoMPAS Sitipe-Service Allows users to integrate Siemens Sitipe within the CoMPAS environment.

## Development

Information about how to run and develop for this project check  [Development](./DEVELOPMENT.md).

## Environment Variables

|Environment Variable  | Default  | Example |
|--|--|--|
| JWT_VERIFY_KEY  | http://localhost:8089/auth/realms/compas/protocol/openid-connect/certs | http://localhost:8089/auth/realms/compas/protocol/openid-connect/certs |
| JWT_VERIFY_ISSUER | http://localhost/auth/realms/compas | http://localhost/auth/realms/compas |
| JWT_VERIFY_CLIENT | sitipe-service | sitipe-service |
| JWT_GROUPS_PATH | resource_access/sitipe-service/roles | resource_access/sitipe-service/roles |
| SITIPE_FRAMEWORK_ID | - | cf1 |
| SITIPE_VERSION | 1.00 | 1.00 |
| SITIPE_MSSQL_URL | _ | jdbc:sqlserver://localhost:1433;databaseName=DB_2019_IC1;ssl-mode=disabled;trustServerCertificate=true;encrypt=false;integratedSecurity=false;
| SITIPE_MSSQL_USER | sa | sa |
| SITIPE_MSSQL_PASSWORD | - | bigStrongPwd123! |

## Security

To use most of the endpoints the users needs to be authenticated using JWT in the authorization header. There are [4 environment variables](#environment-variables) that can be set in the container to configure the validation/processing of the JWT.

## Local Development
You can start the mssql database by running one of the following commands:

### Mac M1
```
docker-compose --env-file docker/.env -f docker/docker-compose-m1.yml up -d --build
```

### AMD64
```
docker-compose --env-file docker/.env -f docker/docker-compose-amd64.yml up -d --build
```

Quarkus can be started in dev mode:
```
./mvnw -DskipTests=true  package io.quarkus:quarkus-maven-plugin::dev
```