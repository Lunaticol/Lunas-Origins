summon tnt ~ ~5 ~ {Fuse:100,Tags:["rain"]}
scoreboard players add @e[tag=rain] command 1
spreadplayers ~ ~ 0 39 under 20 false @e[tag=rain,scores={command=1}]
execute as @e[type=tnt,scores={command=1}] at @s run tp @s ~ ~5 ~