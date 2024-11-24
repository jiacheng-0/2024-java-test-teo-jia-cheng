SELECT p.Name, s.Sport, s.Score FROM players p
    inner join scores s on p.Player_no = s.Player_no
order by s.score desc, p.name desc;