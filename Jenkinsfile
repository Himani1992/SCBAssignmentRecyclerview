pipeline {
    agent {
        label "master"
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '30', daysToKeepStr: '7'))
        timestamps()
    }

    stages {

        stage('Build Staging APK') {

            steps {
            //    withCredentials([string(credentialsId: 'BETA_SECRET_KEY', variable: 'SECRET_KEY')]) {
                  //  bat 'gradlew.bat clean build'
              //  }

              withEnv(["JAVA_HOME=${ tool 'Jdk8u144' }"]){
                    bat 'gradlew.bat clean build'
              }
            }

            post {
                failure {
                    echo "Build Staging APK Failure!"
                }
                success {
                    echo "Build Staging APK Success!"

                }
            }
        }

        stage('Upload') {
            steps {
                archiveArtifacts(artifacts: 'app/**/app-release.apk', fingerprint: true, onlyIfSuccessful: true)
            }
            post {
                failure {
                    echo "Archive Failure!"
                }
                success {
                    echo "Archive Success!"
                }
            }
        }

        stage('Email'){
           steps {

                emailext attachLog: true,  body: '''Hello Team,
                BSA_academy_android of BSA_academy_android apk.
                ''', compressLog: true, subject: 'BSA_academy_android_apk', to: 'himani.borse@capgemini.com'

                 }

            post {
                failure {
                    echo "Email Sending Fail!"
                }
                success {
                    echo "Email has been Sent Successfully!!"
                }
            }
        }

            stage('Report') {
            steps {
                echo getChangeString()
            }
        }
    }
}

@NonCPS
def getChangeString() {
    MAX_MSG_LEN = 100
    def changeString = ""

    echo "Gathering SCM Changes..."
    def changeLogSets = currentBuild.changeSets
    for (int i = 0; i < changeLogSets.size(); i++) {
        def entries = changeLogSets[i].items
        for (int j = 0; j < entries.length; j++) {
            def entry = entries[j]
            truncated_msg = entry.msg.take(MAX_MSG_LEN)
            changeString += "[${entry.author}] ${truncated_msg}\n"
        }
    }

    if (!changeString) {
        changeString = " - No Changes -"
    }
    return changeString
}
