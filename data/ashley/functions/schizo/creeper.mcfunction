summon creeper ~ ~ ~ {Silent:1b,DeathLootTable:"minecraft:empty",CanPickUpLoot:0b,Tags:["notreal"],CustomName:'{"bold":true,"color":"white","text":"Schizophrenia"}',Attributes:[{Name:"generic.armor",Base:80},{Name:"generic.movement_speed",Base:0.44},{Name:"generic.follow_range",Base:256}]}
damage @e[tag=notreal,sort=nearest,limit=1] 1 player_attack by @s
power grant @e[tag=notreal] ashley:mob
spreadplayers ~ ~ 16 16 under 319 false @e[tag=notreal,type=creeper,sort=nearest,limit=1]