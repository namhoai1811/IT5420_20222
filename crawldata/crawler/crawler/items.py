# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy
from scrapy import Item, Field
class CrawlBatdongsansoItem(Item):
    title = Field()
    content = Field()
    price = Field()
    type = Field()
    address = Field()
    date = Field()
    property = Field()
    code = Field()
    name_contact = Field()
    phone_contact = Field()
    link_image = Field()
    url_page = Field()
