CREATE TABLE `hackers` (
  `hacker_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL
);

CREATE TABLE `submissions` (
	`submission_id` int(11) NOT NULL,
	`hacker_id` int(11) NOT NULL,
    `challenge_id` int(11) NOT NULL,
	`score` int(11) DEFAULT NULL
);
