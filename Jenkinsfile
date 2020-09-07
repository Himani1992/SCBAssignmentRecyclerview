pipeline {

    agent {
        label "master"
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '30', daysToKeepStr: '7'))
        timestamps()
    }

    environment {
        apkName = "No Default Apk"
        emailTo = ""
        messageDetails = ""
        failMessage = "console to view the results."
        successMessage = " to find the apk attachment file."
        devTeam = "himani.borse@capgemini.com"
        testingTeam = "himani.borse@capgemini.com"
   }

    stages {

        stage('Build PreStaging MultiAPK') {
            when {
                branch 'multiapk_staging'
            }

            steps {
                echo "******* Start Build PreStaging MultiAPK"
                withEnv(["JAVA_HOME=${ tool 'Jdk8u144' }"]){
                        bat 'gradlew.bat clean build'
                        //bat 'gradlew.bat assembleRelease'
                }
                //archiveArtifacts '**/app-release.apk'
                archiveArtifacts(artifacts: 'app/build/outputs/apk/**/*.apk', fingerprint: true, onlyIfSuccessful: true)
            }

            post {
                failure {
                    echo "******* Build PreStaging MultiAPK Failure!"
                    script {
                        emailTo = "${devTeam}"
                        messageDetails = "${failMessage}"
                    }
                    sendEmail();
                }
                success {
                    echo "******* Build PreStaging MultiAPK Success!"
                    script {
                        emailTo = "${testingTeam}"
                        //apkName = "app-release.apk"
                        messageDetails = "${successMessage}"
                    }
                    sendEmail();
                }
            }
        }

// Following stage is perfect for reference
        stage('Build PreStaging APK') {
            when {
                branch 'developer1'
            }

            steps {
                echo "******* Start Build PreStaging APK"
                withEnv(["JAVA_HOME=${ tool 'Jdk8u144' }"]){
                        //bat 'gradlew.bat clean build'
                        bat 'gradlew.bat assembleRelease'
                }
                archiveArtifacts '**/app-release.apk'
            }

            post {
                failure {
                    echo "******* Build PreStaging Staging APK Failure!"
                    script {
                        emailTo = "${devTeam}"
                        messageDetails = "${failMessage}"
                    }
                    sendEmail();
                }
                success {
                    echo "******* Build PreStaging Staging APK Success!"
                    script {
                        emailTo = "${testingTeam}"
                        apkName = "app-release.apk"
                        messageDetails = "${successMessage}"
                    }
                    sendEmail();
                }
            }
        }

        stage('Build Staging APK') {
            when {
                branch 'staging'
            }

            steps {
                echo "******* Start Build Staging APK"
                withEnv(["JAVA_HOME=${ tool 'Jdk8u144' }"]){
                        bat 'gradlew.bat assembleRelease'
                }
                archiveArtifacts '**/app-release.apk'
            }

            post {
                failure {
                    echo "******* Build Staging APK Failure!"
                    script {
                        emailTo = "${devTeam}"
                        messageDetails = "${failMessage}"
                    }
                    sendEmail();
                }
                success {
                    echo "******* Build Staging APK Success!"
                    script {
                        emailTo = "${testingTeam}"
                        apkName = "app-release.apk"
                        messageDetails = "${successMessage}"
                    }
                    sendEmail();
                }
            }
        }

         stage('Build Himani_staging APK') {
                    when {
                        branch 'Himani_staging'
                    }

                    steps {
                        echo "******* Start Build Staging APK"
                        withEnv(["JAVA_HOME=${ tool 'Jdk8u144' }"]){
                                bat 'gradlew.bat assembleRelease'
                        }
                      //  archiveArtifacts '**/app-release.apk'
                          archiveArtifacts(artifacts: 'app/build/outputs/apk/**/*.apk', fingerprint: true, onlyIfSuccessful: true)
                    }

                    post {
                        failure {
                            echo "******* Build Staging APK Failure!"
                            script {
                                emailTo = "${devTeam}"
                                messageDetails = "${failMessage}"
                            }
                            sendEmail();
                        }
                        success {
                            echo "******* Build Staging APK Success!"
                            script {
                                emailTo = "${testingTeam}"
                                apkName = "app-release.apk"
                                messageDetails = "${successMessage}"
                            }
                            sendEmail();
                        }
                    }
                }


        stage('Build Production APK') {
            when {
                branch 'master'
            }

            steps {
                echo "******* Start Build Production APK"
                withEnv(["JAVA_HOME=${ tool 'Jdk8u144' }"]){
                        bat 'gradlew.bat assembleRelease'
                }
                archiveArtifacts '**/app-release.apk'
            }

            post {
                failure {
                    echo "******* Build Production APK Failure!"
                    script {
                        emailTo = "${devTeam}"
                        messageDetails = "${failMessage}"
                    }
                    sendEmail();
                }
                success {
                    echo "******* Build Production APK Success!"
                    script {
                        emailTo = "${testingTeam}"
                        apkName = "app-release.apk"
                        messageDetails = "${successMessage}"
                    }
                    sendEmail();
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

def sendEmail() {
    echo "******* Email emailTo : ${emailTo} , Apk name : ${apkName}"

    emailext body        : "Dear Team, Build Notification: ${JOB_NAME} - Build # ${BUILD_NUMBER} - ${currentBuild.currentResult}: Check console output at ${env.BUILD_URL}${messageDetails}",
    //attachmentsPattern   : "**/${apkName}",
    subject              : "${JOB_NAME} - Build # ${BUILD_NUMBER} - ${currentBuild.currentResult}",
    to                   : "${emailTo}";
}