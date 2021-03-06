grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.docs.output.dir = "web-app/docs"

gsptaglib.addRequiredAsserts = true

grails.project.dependency.resolution = {
    inherits("global")
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()
        mavenLocal()
    }

    dependencies {
        compile('org.quartz-scheduler:quartz:1.8.6') {
            excludes "slf4j-api", "c3p0", "jta"
        }
    }

    plugins {
        compile ':webflow:2.0.0'
        compile ':rich-domain:1.0.5'
        compile ':gsp-taglib:0.5'
        compile ':resources:1.1.6'
        compile ':jquery:1.7.1'
        compile ":hibernate:$grailsVersion"

        build ":tomcat:$grailsVersion"
        build ':cloud-support:1.0.8'
        build (':cloud-foundry:1.2.1') {
            excludes 'cloud-support'
        }
    }
}

grails.plugin.location.'docs' = "../docs"
//grails.plugin.location.'gsp-taglig' = "../../gsp-taglib"
