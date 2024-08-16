summon zombie ~ ~ ~ {Silent:1b,NoAI:1b,Tags:["Command"]}
effect give @e[tag=Command] invisibility infinite 0 true
power grant @e[tag=Command] command:command
origin set @a[team=Command] origins:origin command:warrior/warrior
function command:messages/message_start