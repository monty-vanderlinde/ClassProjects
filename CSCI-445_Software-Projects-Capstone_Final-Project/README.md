# CSCI Capstone Final Project
Unfortunately, due to the nature of working for a company (Blue Cross & Blue Shield) on this project, I cannot release the source code.
However, I can release the video above of a sample run of the finished product, along with a short version of our final presentation found at either of the following links:
* [The short presentation hosted on NDSU's website](https://csprojects.cs.ndsu.nodak.edu/capstone/PreviousProjects/projects/?project=2020_BCBS)
* [The short presentation hosted on YouTube](https://www.youtube.com/watch?v=ctdrVGO8u1o)

This project was developed using [Ansible](https://www.ansible.com/), an automation tool developed by Red Hat Inc, but free to use on its own.
Ansible uses OpenSSH, including existing ssh infrastructure, to run commands remotely and return the results organized in a JSON file.
This can be automatically parsed using Jinja2 (a python-based, templating language) to produce neat and condensed results from complex actions, as seen in the video above.
Documentation for Ansible and Jinja2 can be [found here](https://docs.ansible.com/ansible/latest/index.html).

The overall goal of this project was to create a prototype Ansible script (or playbook) that automatically queries servers for needed updates, parses and organizes the data, and emails the results to a list of designated recipients.
The project was a complete success, and is being further developed by Blue Crosss & Blue Shield right now.
This will eventually replace a piece of software that is costing the company a significant amount of money in anual subscriptions.
