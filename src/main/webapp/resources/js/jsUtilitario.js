/* 
 * @Autor IdeiatecTecnologia
 * Todos os direitos reservados.
 */

function validaCPF(field) {
    var checkstr = "0123456789";
    var cpfValue = "";
    var cpfTemp = "";

    cpfValue = field.value;
    /* Delete all chars except 0..9 */
    for (i = 0; i < cpfValue.length; i++) {
        if (checkstr.indexOf(cpfValue.substr(i, 1)) >= 0) {
            cpfTemp = cpfTemp + cpfValue.substr(i, 1);
        }
    }

    if (cpfTemp.length == 11) {
        if (cpfTemp == "00000000000" || cpfTemp == "11111111111" || cpfTemp == "22222222222"
                || cpfTemp == "33333333333" || cpfTemp == "44444444444" || cpfTemp == "55555555555"
                || cpfTemp == "66666666666" || cpfTemp == "77777777777" || cpfTemp == "88888888888" ||
                cpfTemp == "99999999999") {
            field.select();
            alert("CPF Invalido.");
            return false;
        } else {
            var a = [];
            var b = new Number;
            var c = 11;
            for (i = 0; i < 11; i++) {
                a[i] = cpfTemp.charAt(i);
                if (i < 9)
                    b += (a[i] * --c);
            }
            if ((x = b % 11) < 2) {
                a[9] = 0;
            } else {
                a[9] = 11 - x;
            }
            b = 0;
            c = 11;
            for (y = 0; y < 10; y++)
                b += (a[y] * c--);
            if ((x = b % 11) < 2) {
                a[10] = 0;
            } else {
                a[10] = 11 - x;
            }
            if ((cpfTemp.charAt(9) != a[9]) || (cpfTemp.charAt(10) != a[10])) {
                field.select();
                alert("Digito verificador do CPF invalido.");
                return false;
            } else {
                return true;
            }
        }
    } else if (cpfTemp.length >= 1) {
        field.select();
        alert("CPF deve conter 11 digitos numericos.");
        return false;
    }
}

function validaEmail(field) {
    var email = "";
    email = field.value;
    if (email.length >= 1) {
        if (!email.match(/([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+.[a-zA-Z0-9._-]+)/gi)) {
            field.select();
            alert("Informe um e-mail valido.\n Exemplo: e-mail@dominio.ext");
            return false;
        }
    }
    else
        return true;
}

function maiuscula(campo, e) {
    var tecla = e.keyCode;
    // verifica se nao e backspace, tab, enter, espa�o, seta p/ esquerda,
    // seta p/ cima, seta p/ direita, seta p/ baixo, null
    if (tecla != 8
            && tecla != 9
            && tecla != 13
            && tecla != 32
            && tecla != 37
            && tecla != 38
            && tecla != 39
            && tecla != 40
            && tecla != 0) {
        campo.value = campo.value.toUpperCase();
    }
}

function soNumeros(v) {
    return v.replace(/\D/g, ""); // Remove tudo o que nao e digito
}

function soNumeros2(v) {
    return v.replace(/[^0-9.,\-]/g, ""); // Remove tudo o que nao e digito menos virgula, ponto ou menos
}

function soNumerosEVirgula(v) {
    return v.replace(/[^0-9,]/g, ""); // Remove tudo o que nao e digito menos virgula
}

function soNumerosEv(e) {
    var tecla = (window.event) ? event.keyCode : e.which;
    if ((tecla > 47 && tecla < 58))
        return true;
    else {
        if (tecla === 8 || tecla === 0){
            return true;
        }else{
            return false;
        }
    }
}

function soLetrasEv(e) {
    var tecla = (window.event) ? event.keyCode : e.which;
    var expressao = /[a-zA-Z]/;
    if(expressao.test(String.fromCharCode(tecla))){
        return true;
    } else {
        return false;
    }
}

function data(v) {
    // 31/12/1999
    v = v.replace(/\D/g, ""); // Remove tudo o que nao e digito
    v = v.replace(/(\d{2})(\d)/, "$1/$2"); // Coloca uma barra entre o segundo e o terceiro digitos
    v = v.replace(/(\d{2})(\d)/, "$1/$2"); // Coloca um ponto entre o segundo e o terceiro digitos
    return v;
}

function validaData(field) {
    var checkstr = "0123456789";
    var DateField = field;
    var DateValue = "";
    var DateTemp = "";
    var seperator = "/";
    var day;
    var month;
    var year;
    var leap = 0;
    var err = 0;
    var i;
    err = 0;
    DateValue = DateField.value;

    if (DateValue.length > 0 && DateValue.length < 10) {
        alert("O campo da data deve ter o formato: DD/MM/AAAA.");
        DateField.select();
        return false;
    }

    /* Delete all chars except 0..9 */
    for (i = 0; i < DateValue.length; i++) {
        if (checkstr.indexOf(DateValue.substr(i, 1)) >= 0) {
            DateTemp = DateTemp + DateValue.substr(i, 1);
        }
    }
    DateValue = DateTemp;
    /* Always change date to 8 digits - string */
    /* if year is entered as 2-digit / always assume 20xx */
    if (DateValue.length == 6) {
        DateValue = DateValue.substr(0, 4) + '20' + DateValue.substr(4, 2);
    }
    if (DateValue.length != 8) {
        err = 19;
    }
    /* year is wrong if year = 0000 */
    year = DateValue.substr(4, 4);

    // if (year == 0 || year > 9999 || year <= 0000) {
    if (year == 0 || year > 9999) {
        err = 20;
    }
    /* Validation of month */
    month = DateValue.substr(2, 2);
    if ((month < 1) || (month > 12)) {
        err = 21;
    }
    /* Validation of day */
    day = DateValue.substr(0, 2);
    if (day < 1) {
        err = 22;
    }
    /* Validation leap-year / february / day */
    if ((year % 4 == 0) || (year % 100 == 0) || (year % 400 == 0)) {
        leap = 1;
    }
    if ((month == 2) && (leap == 1) && (day > 29)) {
        err = 23;
    }
    if ((month == 2) && (leap != 1) && (day > 28)) {
        err = 24;
    }
    /* Validation of other months */
    if ((day > 31) && ((month == "01") || (month == "03") || (month ==
            "05") || (month == "07") || (month == "08") || (month == "10") || (month
            == "12"))) {
        err = 25;
    }
    if ((day > 30) && ((month == "04") || (month == "06") || (month ==
            "09") || (month == "11"))) {
        err = 26;
    }
    /* if 00 ist entered, no error, deleting the entry */
    if ((day == 0) && (month == 0) && (year == 00)) {
        err = 0;
        day = "";
        month = "";
        year = "";
        seperator = "";
    }
    /*
     * if no error, write the completed date to Input-Field (e.g. 13.12.2001)
     */
    if (err == 0) {
        DateField.value = day + seperator + month + seperator + year;

        return true;

    }
    /* Error-message if err != 0 */
    else {
        DateField.select();
        field.value = "";

        alert("Data invalida.");
        return false;
    }
}

function cep(v) {
    // 12.123-123
    v = v.replace(/D/g, "");// Remove tudo o que nao e digito
    v = v.replace(/^(\d{2})(\d)/, "$1.$2"); //
    v = v.replace(/(\d{3})(\d)/, "$1-$2");//
    return v;
}

function telefoneComDDD(v) {
    // (12) 1234-1234
    v = v.replace(/\D/g, "");// Remove tudo o que nao e digito
    v = v.replace(/^(\d\d)(\d)/g, "($1) $2"); //Coloca parenteses em volta dos dois primeiros digitos
    v = v.replace(/(\d{4})(\d)/, "$1-$2");// Coloca h�fen entre o quarto e o quinto digitos
    return v;
}

function formatTime(secs) {
    var times = new Array(3600, 60, 1);
    var time = '';
    var tmp;
    for (var i = 0; i < times.length; i++) {
        tmp = Math.floor(secs / times[i]);
        if (tmp < 1) {
            tmp = '00';
        }
        else if (tmp < 10) {
            tmp = '0' + tmp;
        }
        time += tmp;
        if (i < 2) {
            time += ':';
        }
        secs = secs % times[i];
    }
    return time;
}

function cancelaSubmitEventEnter(e) {
    var key;

    if (window.event) {
        // for IE, e.keyCode or window.event.keyCode can be used
        key = e.keyCode;
    } else if (e.which) {
        // netscape
        key = e.which;
    } else {
        // no event, so pass through
        return true;
    }

    // Se for ENTER busca.
    if (key === 13) {
        // SE FOR O INPUT TEXT AREA DEIXA
        if (obterNomeTargetEvent(e) === 'TEXTAREA') {
            return true;
        }
        // CANCELANDO O SUBIMIT DEFALUT
        // DO FORM QUANDO APERTA ENTER
        if (e.preventDefault) {
            e.preventDefault();
        } else {
            e.returnValue = false;
            e.cancel = true;
        }
    }
}

function obterNomeTargetEvent(e) {
    var elem, evt = e ? e : event;
    if (evt.srcElement) {
        elem = evt.srcElement;
    } else if (evt.target) {
        elem = evt.target;
    } else {
        return '';
    }
    return elem.tagName.toUpperCase();
}

function onEnterClickButton(e, idButton) {
    var key;

    if (window.event) {
        // for IE, e.keyCode or window.event.keyCode can be used
        key = e.keyCode;
    } else if (e.which) {
        // netscape
        key = e.which;
    } else {
        // no event, so pass through
        return true;
    }

    // Se for ENTER busca.
    if (key === 13) {
        $(idButton).focus();
        $(idButton).click();
        // CANCELANDO O SUBIMIT DEFALUT
        // DO FORM QUANDO APERTA ENTER
        if (e.preventDefault) {
            e.preventDefault();
        } else {
            e.returnValue = false;
            e.cancel = true;
        }
        return false;
    }
    return true;
}

function onEnterChange(e) {
    var key;

    if (window.event) {
        // for IE, e.keyCode or window.event.keyCode can be used
        key = e.keyCode;
    } else if (e.which) {
        // netscape
        key = e.which;
    } else {
        // no event, so pass through
        return true;
    }

    // Se for ENTER busca.
    if (key === 13) {
        e.target.onchange(e);
        // CANCELANDO O SUBIMIT DEFALUT
        // DO FORM QUANDO APERTA ENTER
        if (e.preventDefault) {
            e.preventDefault();
        } else {
            e.returnValue = false;
            e.cancel = true;
        }
        return false;
    }
    return true;
}

function facetCheckBoxDt(facetCheckBox, idItemCheckBox) {
    var item = $('[id*=' + idItemCheckBox + ']');
    if (item.length !== 0) {
        for (var i = 0; i < item.length; i++) {
            item[i].checked = facetCheckBox.checked;
        }
    }
}

function itemCheckBoxDt(idItemCheckBox, idFacetCheckBox) {
    // VERIFICANDO SE TODOS OS ITENS ESTAO SELECIONADOS
    var item = $('[id*=' + idItemCheckBox + ']');
    var bTodosSel = true;
    if (item.length !== 0) {
        for (var i = 0; i < item.length; i++) {
            if (!item[i].checked) {
                bTodosSel = false;
            }
        }
    }
    // CABECALHO COLUNA
    var facetCheckBox = $('[id*=' + idFacetCheckBox + ']');
    if (bTodosSel) {
        facetCheckBox[0].checked = true;
    } else {
        facetCheckBox[0].checked = false;
    }
}

function tabOnEnter(field, e, qtdPulo) {
    var key;

    if (window.event) {
        // for IE, e.keyCode or window.event.keyCode can be used
        key = e.keyCode;
    } else if (e.which) {
        // netscape
        key = e.which;
    } else {
        // no event, so pass through
        return true;
    }

    // Se for ENTER busca.
    if (key === 13) {
        //e.target.onchange();
        var element = nextElement(field, qtdPulo);
        element.focus();
        // CANCELANDO O SUBIMIT DEFALUT
        // DO FORM QUANDO APERTA ENTER
        if (e.preventDefault) {
            e.preventDefault();
        } else {
            e.returnValue = false;
            e.cancel = true;
        }
        return false;
    }
    return true;
}

function tabOnMaxLength(field, maxLength, qtdTab) {
    if (field.value.length === maxLength) {
        var element = nextElement(field, qtdTab);
        element.focus();
        element.select();
        return false;
    }
    return true;
}

function nextElement(field, qtdTab) {
    var form = field.form;
    for (var e = 0; e < form.elements.length; e++) {
        if (field === form.elements[e]) {
            break;
        }
    }
    return form.elements[(e + qtdTab) % form.elements.length];
}


function TimerSessao(options) {
    var timer;
    var seconds = options.seconds || 10;
    var onUpdateStatus = options.onUpdateStatus || function () {
    };
    var onCounterEnd = options.onCounterEnd || function () {
    };
    var onCounterStart = options.onCounterStart || function () {
    };

    function decrementCounter() {
        onUpdateStatus(seconds);
        if (seconds === 0) {
            stopCounter();
            onCounterEnd();
            return;
        }
        seconds--;
    }
    ;

    function startCounter() {
        onCounterStart();
        clearInterval(timer);
        timer = 0;
        decrementCounter();
        timer = setInterval(decrementCounter, 1000);
    }
    ;

    function stopCounter() {
        clearInterval(timer);
    }
    ;

    function restartCounter() {
        seconds = options.seconds || 10;
        onCounterStart();
        clearInterval(timer);
        timer = 0;
        decrementCounter();
        timer = setInterval(decrementCounter, 1000);
    }
    ;

    return {
        start: function () {
            startCounter();
        },
        stop: function () {
            stopCounter();
        },
        restart: function () {
            restartCounter();
        }
    }
    ;
}
;

function ajustaWidthInputForm(){
    var item = $('.inputForm');
    /* AJUSTA DIFERENCA DE 14 */
    if (item.length !== 0) {
        for (var i = 0; i < item.length; i++) {
            var widthInput = $(item[i]).width();
            widthInput -= 10;
            $(item[i]).width(widthInput);
        }
    }
}

function booleanNot(bool){
    return !bool;
}