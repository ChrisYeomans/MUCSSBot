import discord, os

def main():
    TOKEN = open('token.txt', 'r').read().strip()
    client = discord.Client()

    @client.event
    async def on_ready():
        print("Bot Ready")

    @client.event
    async def on_message(message):
        c = message.content.lower()
        if c == "ping":
            await message.channel.send("pong")
        elif c == "mc?":
            response = os.system("ping -c 1 " + "https://mc.mucssoc.com")
            if response == 0:
                await message.channel.send("The Minecraft Server is up!")
            else:
                await message.channel.send("The Minecraft Server is down!")

    client.run(TOKEN)


if __name__ == "__main__":
    main() 