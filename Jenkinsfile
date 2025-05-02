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
stage('Clean Workspace') {
            steps {
                script {
                    try {
                        cleanWs()
                    } catch (err) {
                        echo "cleanWs() failed: ${err}. Trying manual cleanup..."
                        sh 'rm -rf *'
                    }
                }
            }
        }

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
            emailext (
                subject: "Automation Test Report - Build #${BUILD_NUMBER}",
                body: """
                    <p>Hi,</p>
                    <p>The test suite has completed. Please find the <a href="${BUILD_URL}HTML_20Report/">Extent Report</a>.</p>
                    <p>Status: <strong>${currentBuild.currentResult}</strong></p>
                """,
                mimeType: 'text/html',
                to: 'jyothilakshmisree04@gmail.com'
            )
        }
    }

}