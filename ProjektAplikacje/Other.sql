
-------------------------------------------kwarenda--------------------------

--Tworzy widok o nazwie "pasazer_informacje", który wyœwietla o ka¿dym pasa¿erze takie informacje jak:
--kolumna wyliczeniowa "ilosc_rez", czyli ca³kowita iloœæ rezerwacji samolotwych, kolumna wyliczeniowa
--"czy_wyda³_w_liniach" z wartoœciami TAK/NIE/BRAK (TAK gdy pasa¿er wyda³ coœ na pok³adzie, NIE gdy nigdy nic nie kupuil, BRAK w pozosta³ych przypadkach).
--Laczy encje pasazer,kraj,rezerwacja
Drop View pasazer_informacje

CREATE VIEW pasazer_informacje AS

SELECT p.id_pasazer,p.imie,p.nazwisko, k.nazwa, COUNT(r.pasazer_id) AS "ilosc_rez",
CASE WHEN p.czy_wyda³_w_liniach>0 THEN 'TAK' WHEN p.czy_wyda³_w_liniach=0 THEN 'NIE' else 'BRAK' END AS czy_kupowal FROM pasazer p LEFT JOIN rezerwacja r ON p.id_pasazer=r.pasazer_id join kraj k On k.kraj_id=p.kraj_id  
GROUP BY p.id_pasazer,p.imie,p.nazwisko,k.nazwa,p.czy_wyda³_w_liniach;

GO

SELECT * FROM pasazer_informacje GROUP BY id_pasazer,imie, nazwisko, nazwa, ilosc_rez,czy_kupowal  HAVING ilosc_rez>(SELECT AVG(ilosc_rez) FROM pasazer_informacje WHERE czy_kupowal = 'TAK') ;
Go

-------------------------------------------PROCEDURA--------------------------

drop proc obni¿ka_op³at_dla_najczesciej_podrozujacych

--4a) Tworzymy procedurê 1, która obni¿a cene dla pasa¿era który najczêsciej podró¿uje i zmienia mu narodowosc.
CREATE PROC obni¿ka_op³at_dla_najczesciej_podrozujacych
@obnizka MONEY
AS BEGIN
DECLARE @id_najczestszego_pasazera INT
SET @id_najczestszego_pasazera=(SELECT TOP 1 p.id_pasazer FROM pasazer p JOIN rezerwacja r ON p.id_pasazer=r.pasazer_id join kraj k On k.kraj_id=p.kraj_id GROUP BY p.id_pasazer
ORDER BY COUNT(p.id_pasazer ) DESC)
UPDATE pasazer SET czy_wyda³_w_liniach=czy_wyda³_w_liniach-@obnizka WHERE id_pasazer=@id_najczestszego_pasazera;
UPDATE pasazer SET kraj_id=5 WHERE id_pasazer=@id_najczestszego_pasazera;
SELECT*FROM pasazer;
END

EXEC obni¿ka_op³at_dla_najczesciej_podrozujacych 500;
GO


---------------------------------------------WYZWALACZ--------------------------------
-- Tworzymy wzywalacz 3, który przy usuwaniu producenta samolotu daje nam informacje o jego za³ozycielu i nazwie.

CREATE TRIGGER usun_producenta_samolotu ON producent_samolotu
AFTER DELETE
AS
BEGIN
    DECLARE kursor__producent_samolot_delete CURSOR
    FOR SELECT nazwa_producenta, ceo  FROM DELETED;
    DECLARE @nazwa_producenta VARCHAR(10), @ceo VARCHAR(20)

	OPEN kursor__producent_samolot_delete
    FETCH NEXT FROM kursor__producent_samolot_delete INTO @nazwa_producenta, @ceo
    WHILE @@FETCH_STATUS = 0
    BEGIN
        PRINT 'Usunieto ' + @nazwa_producenta+ ' zalozonego przez ' + @ceo
        FETCH NEXT FROM kursor__producent_samolot_delete INTO @nazwa_producenta, @ceo
	END
    CLOSE kursor__producent_samolot_delete
    DEALLOCATE kursor__producent_samolot_delete
END
 
-- Sprawdzenie, ¿e wyzwalacz 3 dzia³a
DELETE FROM producent_samolotu WHERE id_producent_samolotu IN(6, 7);
GO

SELECT * FROM producent_samolotu;


