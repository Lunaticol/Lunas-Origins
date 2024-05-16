summon wither_skeleton ~ ~ ~ {Silent:1b,DeathLootTable:"minecraft:empty",CanPickUpLoot:0b,Tags:["notreal"],CustomName:'{"bold":true,"color":"white","text":"Schizophrenia"}',Attributes:[{Name:"generic.follow_range",Base:256}]}
damage @e[tag=notreal,sort=nearest,limit=1] 1 player_attack by @s
power grant @e[tag=notreal] ashley:mob
effect give @e[tag=notreal,type=wither_skeleton] speed infinite 3 true
effect give @e[tag=notreal,type=wither_skeleton] resistance infinite 3 true
spreadplayers ~ ~ 16 16 under 319 false @e[tag=notreal,type=wither_skeleton,sort=nearest,limit=1]