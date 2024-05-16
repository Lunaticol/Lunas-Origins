summon zombie ~ ~ ~ {Silent:1b,DeathLootTable:"minecraft:empty",CanPickUpLoot:0b,Tags:["notreal"],CustomName:'{"bold":true,"color":"white","text":"Schizophrenia"}',ArmorItems:[{},{},{},{id:"minecraft:leather_helmet"}],ArmorDropChances:[0.085F,0.085F,0.085F,-327.670F],Attributes:[{Name:"generic.follow_range",Base:256}]}
damage @e[tag=notreal,sort=nearest,limit=1] 1 player_attack by @s
power grant @e[tag=notreal] ashley:mob
effect give @e[tag=notreal,type=zombie] speed infinite 3 true
effect give @e[tag=notreal,type=zombie] resistance infinite 3 true
spreadplayers ~ ~ 16 16 under 319 false @e[tag=notreal,type=zombie]