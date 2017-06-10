function date()
{
    const date = new Date();
    let result = '';
    result += date.getFullYear();
    result += '-';

    let month = date.getMonth() + 1;
    if(month < 10)
    {
        month = '0' + month;
    }

    result += month;
    result += '-';

    let day = date.getDate();
    if(day < 10)
    {
        day = '0' + day;
    }
    result += day;
    return result;
}

function datetime()
{
    let result = date();
    const d = new Date();

    result += ' ';

    let hour = d.getHours();
    if(hour < 10)
    {
        hour = '0' + hour;
    }
    result += hour;

    result += ':';

    let minute = d.getMinutes();
    if(minute < 10)
    {
        minute = '0' + minute;
    }
    result += minute;

    result += ':';

    let second = d.getSeconds();
    if(second < 10)
    {
        second = '0' + second;
    }
    result += second;

    return result;
}

console.log(datetime());

export { date, datetime };