pipeline{
agent any

triggers
{
cron('* * * * *') // Runs every minute

}
tools {
        maven 'Maven 3.8.6'
    }

stages
{
stage('Checkout')
{
steps
{
git url: 'https://github.com/jyothilashmi/jenkins', branch: 'main'
}
}
stage('Run TestNG Suite')
{
steps
{
echo 'Building the project......!!'
bat 'mvn clean test -DsuiteXmlFile=testng.xml'
}

}

stage('Publish Test Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
stage('Publish Extent Report') {
            steps {
                publishHTML([
                    reportDir: 'test-output',              // Folder where ExtentReport.html is located
                    reportFiles: 'ExtentReport.html',      // Report file name
                    reportName: 'Extent Report',           // What it shows in Jenkins UI
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
                ])
            }
        }


}
post {
        always {
            cleanWs()
        }

        success {
            echo 'TestNG suite ran successfully!'
        }

        failure {
            echo 'TestNG suite failed. Check logs.'
        }
    }
}