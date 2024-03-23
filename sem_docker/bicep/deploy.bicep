@description('Unique app name')
param webAppName string = 'appservice-sem'
@allowed(['F1'])
param sku string = 'F1'
param linuxFxVersion string = 'TOMCAT|10.1-java21'
param location string = resourceGroup().location

var appServicePlanName = 'app-service-plan-${webAppName}'

resource appServicePlan 'Microsoft.Web/serverfarms@2023-01-01' = {
  name: appServicePlanName
  location: location
  properties: {
    reserved: true
  }
  sku: {
    name: sku
  }
  kind: 'linux'
}

resource appService 'Microsoft.Web/sites@2023-01-01' = {
  name: webAppName
  location: location
  properties: {
    serverFarmId: appServicePlan.id
    siteConfig: {
      linuxFxVersion: linuxFxVersion
    }
  }
}
