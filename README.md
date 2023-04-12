# FastSport

https://docs.google.com/document/d/1mzEQ52Fe8h7bQkDOV-2rgSoo0hPQdmRCCOtsDr14vfA/edit

Problem Definition:

Here at FastModel we are innovators of the sport. We aim to come up with our own special proprietary stat called the "FastStat" that is calculated by the following.

((Total Points + Rebounds + Assist) - Turnovers)
 
+

If they are over 6 feet they get an additional point for every inch they are over 6 feet.

+

If their first and last name begins with the same letter they also get an additional 10 points.

+

Last but not least they get the value of their jersey number and their age added to their "FastStat" total as well.


Interview task:

Given a list of player stats (sample.json) create a spring boot endpoint that does the following:


Respond with a list of objects that include the initial values of the sample.json along with the new "FastStat" field
The response should be sorted by the "FastStat" score in descending order.


Sample Data(sample.json): 

https://drive.google.com/file/d/1RYXes3Z3KO6VyZMjJYMyVIoxg2iD-TBs/view?usp=share_link


Endpoint:

{{host}}/faststat

Response Example:

[
  {
            "name": "Avery Adams",
            "height": "6'3\"",
            "number": "11",
            "birthdate": "1990-11-26",
            "PTS": 423,
            "Reb": 115,
            "AST": 63,
            "TO": 47,
            "FastStat": 610
    },
    {
            "name": "Kevin Anthony",
            "height": "6'10\"",
            "number": "37",
            "birthdate": "1997-11-20",
            "PTS": 7,
            "Reb": 3,
            "AST": 2,
            "TO": 1,
            "FastStat": 83
        }

]

Deliverables: 

Project should be written in Java and spring boot. when done zip your project and email it to daniel@fastmodeltechnologies.com


Endpoint : http://localhost:8083/faststat ![image](https://user-images.githubusercontent.com/11165878/231566267-10096e46-38c0-426b-9a79-25574bc1dfe4.png)
