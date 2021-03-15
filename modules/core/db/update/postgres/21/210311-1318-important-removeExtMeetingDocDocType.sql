delete from DF_DOC_KIND where category_id in (select id from SYS_CATEGORY where entity_type='thesistest$MeetingDoc')^
delete from SYS_CATEGORY where entity_type='thesistest$MeetingDoc'^
delete from TS_CARD_TYPE where NAME='thesistest$MeetingDoc' and DISCRIMINATOR='1130'^
