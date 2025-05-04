# Jenkins CI/CD Pipeline Project

This repository contains Jenkins pipeline scripts and configuration files used for automating build, test, and deployment processes in a CI/CD workflow for a simple selenium -testng- java project.

## 📌 Project Overview

The objective of this project is to showcase Jenkins integration for executing automation tests at a scheduled interval (every minute) using a testng.xml suite. The Jenkins pipeline pulls the latest code from GitHub, runs the tests, generates Extent Reports, and sends email notifications (with attached reports) to recipients specified in the Jenkinsfile.


# ⚙️ Technologies Used

- Jenkins (Pipeline as Code)
- Git/GitHub
- Shell Scripting
- Maven
- Extent reports
- Email notifications

## 🚀 Getting Started

### Prerequisites

- Jenkins installed (locally or via container)
- GitHub access/token
- Required plugins: Pipeline, Git, Email Extension, Docker Pipeline (if used)

### Setup Instructions

1. Clone this repository:
   ```bash
   git clone https://github.com/jyothilashmi/jenkins.git
   cd jenkins
2. Create a new Jenkins pipeline job.

3. Point the pipeline to use the Jenkinsfile in this repo:

Option: "Pipeline script from SCM"

SCM: Git

Repo URL: https://github.com/jyothilashmi/jenkins.git
4. Configure credentials and environment as needed.

5. Run the pipeline and monitor execution.
