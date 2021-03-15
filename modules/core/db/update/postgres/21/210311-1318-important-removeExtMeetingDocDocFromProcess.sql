update wf_proc set card_types = regexp_replace(card_types, E',thesistest\\$MeetingDoc', '') where code in ('Endorsement','Resolution','Acquaintance','Registration')^
