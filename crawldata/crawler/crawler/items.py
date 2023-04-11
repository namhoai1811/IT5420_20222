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


class CrawlIBatdongsanItem(Item):
    title = Field()
    price = Field()
    address = Field()
    area = Field()
    date = Field()
    brief = Field()
    code = Field()
    type = Field()
    width = Field()
    length = Field()
    direct = Field()
    world_highway = Field()
    juridical = Field()
    floor = Field()
    bedroom = Field()
    kitchen = Field()
    diningroom = Field()
    terrace = Field()
    parking = Field()
    phone_contact = Field()
    name_contact = Field()
    link_image = Field()
    url_page = Field()

class CrawlBatdongsan123(Item):
    title= Field()
    price = Field()
    description = Field()
    link_image = Field()
    url_page = Field()
    bedroom = Field()
    bathroom = Field()
    acreage = Field()
    address = Field()
    direction = Field()
    date = Field()
    code = Field()
    name_contact = Field()
    phone_contact = Field()
    project = Field()


