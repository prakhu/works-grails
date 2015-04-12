Project
-------
Build a simple grails application to manage project information.
Description
-----------
The application should allow a user to create/edit/delete/view projects.
A project has the following information:
                - project name (alphanumeric)
                - project code (alphanumeric)
                - tech lead (person's name)
                - project manager (person's name)
                - delivery date
                - current phase (one of briefing/scoping/interaction/development/qa/release)
                - priority (numerical)

The priority field goes from 1 (highest) upwards and is dependent on the number of projects (e.g.only one project is number 1 priority). 
Kind of like a 'top of the pops' list. 
Any list view should default to ordering by priority.
Demonstrate use of tests - make sure to cover various user stories.
Demonstrate understanding of 'Separation of concerns' in your solution.
Apply domain relationships where relevant.