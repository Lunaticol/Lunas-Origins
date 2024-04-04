summon arrow ~ ~5 ~
scoreboard players add @e[type=minecraft:arrow] button 1
spreadplayers ~ ~ 0 10 false @e[type=arrow, scores={button=1}]
execute as @e[type=arrow, scores={button=1}] at @s run tp @s ~ ~20 ~