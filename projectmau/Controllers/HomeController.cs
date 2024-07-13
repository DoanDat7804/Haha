using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using projectmau.Data;
using projectmau.Models;
using System.Diagnostics;

namespace projectmau.Controllers
{
    public class HomeController : Controller
    {
		private readonly projectmauContext _context;

		public HomeController(projectmauContext context)
		{
			_context = context;
		}

		public IActionResult Index()
        {
            return View(_context.Product.Include(p => p.category).ToList());
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}