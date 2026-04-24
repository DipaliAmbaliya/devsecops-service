# 🔐 DevSecOps POC: Spring Boot CI/CD Pipeline

## 📌 Overview

This project demonstrates how to integrate automated vulnerability scanning into a Spring Boot CI/CD pipeline.

---

## 🧠 What is Vulnerability Scanning?

Vulnerability scanning is the automated detection of security flaws in applications, dependencies, containers, and secrets.

---

## 🛠️ Tools Used

* Sonar Qube – Static code analysis
* CodeQL – Code query language for vulnerability detection
* Snyk – Dependency scanning (Maven)
* Trivy – Container vulnerability scanning
* TruffleHog – Secret detection
* GitHub Actions – CI/CD pipeline

---

## ⚙️ Pipeline Flow

1. Code is pushed to repository
2. Secrets are scanned
3. Maven build is executed
4. Dependencies are scanned
5. Docker image is built
6. Container image is scanned
7. Deployment occurs if all checks pass

---

## 🔍 Vulnerabilities Demonstrated

* Hardcoded secrets in code
* Outdated Spring Boot dependency
* Cross-site scripting (XSS) vulnerability
* Vulnerable container layers

---

## ▶️ Run Locally

```bash
mvn spring-boot:run
```

OR using Docker:

```bash
docker build -t springboot-devsecops .
docker run -p 8080:8080 springboot-devsecops
```

Test XSS:
http://localhost:8080/?name=<script>alert(1)</script>

---

## 🌍 Benefits

* Early vulnerability detection
* Automated security enforcement
* Reduced risk of production issues
* Improved compliance

---

## ⚠️ Notes

* Add SNYK_TOKEN in GitHub Secrets
* This app is intentionally vulnerable for demonstration

---

## 🎯 Conclusion

This POC demonstrates how DevSecOps integrates security scanning directly into CI/CD pipelines for Spring Boot applications.

* sonar => build failed due to vulnerabilities, but pipeline continues to run and deploys vulnerable code to production. This highlights the importance of enforcing security checks and not just reporting them.
* Snyk => build fails if vulnerabilities are found, preventing deployment of vulnerable code.
* Trivy => build fails if vulnerable container layers are detected, ensuring secure images are deployed.
* TruffleHog => build fails if secrets are detected in code, preventing accidental exposure of sensitive information.

