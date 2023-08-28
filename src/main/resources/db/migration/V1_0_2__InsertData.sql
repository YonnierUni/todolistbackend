INSERT INTO "user"(
	first_name, last_name, email, password)
	VALUES ('Alberto', 'Uni', 'albertouni@gmail.com', '123');

INSERT INTO "user"(
	first_name, last_name, email, password)
	VALUES ('Jose', 'Rojas', 'joserojas@gmail.com', '123');

INSERT INTO "user"(
	first_name, last_name, email, password)
	VALUES ('Marcos', 'Parra', 'marcosparra@gmail.com', '123');

INSERT INTO public.note(
	title, content, is_archived, user_id)
	VALUES ('note1', 'notecontent1',false, 1);

INSERT INTO public.note(
	title, content, is_archived, user_id)
	VALUES ('note2', 'notecontent2',true, 1);

INSERT INTO public.note(
	title, content, is_archived, user_id)
	VALUES ('note3', 'notecontent3',false, 2);

INSERT INTO public.note(
	title, content, is_archived, user_id)
	VALUES ('note4', 'notecontent4',true, 1);

INSERT INTO public.category(
	name, description)
	VALUES ('category1', 'descriptioncategory1');

INSERT INTO public.category(
	name, description)
	VALUES ('category2', 'descriptioncategory2');

INSERT INTO public.category(
	name, description)
	VALUES ('category3', 'descriptioncategory3');

INSERT INTO public.category(
	name, description)
	VALUES ('category4', 'descriptioncategory4');

INSERT INTO public.category(
	name, description)
	VALUES ('category5', 'descriptioncategory5');

INSERT INTO public.category(
	name, description)
	VALUES ('category6', 'descriptioncategory6');

INSERT INTO public.category(
	name, description)
	VALUES ('category7', 'descriptioncategory7');

INSERT INTO public.category(
	name, description)
	VALUES ('category8', 'descriptioncategory8');

INSERT INTO public.note_category(
	note_id, category_id)
	VALUES (1, 1);

INSERT INTO public.note_category(
	note_id, category_id)
	VALUES (2, 2);

INSERT INTO public.note_category(
	note_id, category_id)
	VALUES (3, 3);

INSERT INTO public.note_category(
	note_id, category_id)
	VALUES (1, 4);

INSERT INTO public.note_category(
	note_id, category_id)
	VALUES (3, 4);

INSERT INTO public.note_category(
	note_id, category_id)
	VALUES (2, 4);

INSERT INTO public.note_category(
	note_id, category_id)
	VALUES (2, 5);

INSERT INTO public.note_category(
	note_id, category_id)
	VALUES (2, 6);

INSERT INTO public.note_category(
	note_id, category_id)
	VALUES (2, 7);

INSERT INTO public.note_category(
	note_id, category_id)
	VALUES (2, 8);