function convertToFarhenhiet()
{
	const farhenhietInput=document.getElementById('farhenhietInput').value;
	const celsiusTemparature=(parseFloat(farhenhietInput)-32)*5/9;
	document.getElementById('celsiusOutput').value=celsiusTemparature.toFixed(2);
}