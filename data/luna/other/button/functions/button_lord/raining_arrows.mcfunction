summon arrow ~ ~5 ~ {damage:25d,crit:1b,Tags:["rain"]}
scoreboard players add @e[tag=rain] button 1
spreadplayers ~ ~ 0 10 false @e[tag=rain,scores={button=1}]
execute as @e[type=arrow,scores={button=1}] at @s run tp @s ~ ~20 ~